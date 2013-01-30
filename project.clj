(defproject cascalog-faunus "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.0.0"

  :dependencies [
                  [org.clojure/clojure "1.4.0"]
                  [cascalog "1.10.0"]
                  [cascalog-more-taps "0.3.0"]
                  [com.thinkaurelius.faunus/faunus "0.1.0" :exclusions [com.thinkaurelius.titan/titan
                                                                       ; com.tinkerpop.blueprints/blueprints-core
                                                                        com.tinkerpop.gremlin/gremlin-groovy
                                                                        com.tinkerpop.rexster/rexster-core 
                                                                        org.openrdf.sesame/sesame-rio-n3 
                                                                        org.openrdf.sesame/sesame-rio-ntriples
                                                                        org.openrdf.sesame/sesame-rio-trig
                                                                        org.openrdf.sesame/sesame-rio-trix
                                                                        org.openrdf.sesame/sesame-rio-turtle
                                                                        org.openrdf.sesame/sesame-rio-rdfxml]]
                ]

  :aot [cascalog.faunus.core]

  :profiles {
    :provided {
      :dependencies 
        [[org.apache.hadoop/hadoop-core "0.20.2-dev" :exclusions [log4j org.slf4j/slf4j-log4j12 org.slf4j/slf4j-api]]]} })
