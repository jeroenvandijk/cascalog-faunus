(ns cascalog.faunus.core
  (:use [cascalog.api])
  (:require [cascalog.more-taps :as more])
  (:import [com.thinkaurelius.faunus FaunusVertex FaunusEdge]
           [com.tinkerpop.blueprints Direction]
           [org.apache.hadoop.io NullWritable])
  (:gen-class))

(defn line->rels [^String line]
  (let [[vertex-id edges-str] (.split line ": " 2)
        vertex (FaunusVertex. (Long. vertex-id))]
    (if (.startsWith edges-str "<private>")
      [(NullWritable/get) nil]
      (do (doseq [other-id (.split edges-str ",")]
            (.addEdge vertex Direction/IN (FaunusEdge. (Long. vertex-id) (Long. other-id) "friend"))
            (.addEdge vertex Direction/OUT (FaunusEdge. (Long. other-id) (Long. vertex-id) "friend")))
          [(NullWritable/get) vertex]))))

(defn hfs-faunus [path]
  (more/hfs-wrtseqfile path NullWritable FaunusVertex :outfields ["?key" "?value"]))

(defn -main [input-path output-path]
  "Convert Friendfeed list to Faunus Seqfile"
  (?<- 
    (hfs-faunus output-path)
    [?key ?value]
    ((hfs-textline input-path) ?line)
    (line->rels ?line :> ?key ?value)))
