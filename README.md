# cascalog-faunus

## Usage

Through Leiningen

    lein run -m cascalog.faunus.core data/friendfeed data/faunus
    

On hadoop

    lein uberjar
    
    hadoop jar target/cascalog-faunus-0.1.0-SNAPSHOT-standalone.jar  cascalog.faunus.core data/friendfeed data/faunus


## License

Copyright © 2013 Jeroen van Dijk

Distributed under the Eclipse Public License, the same as Clojure.
