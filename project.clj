(defproject datahack "0.1.0-SNAPSHOT"
  :description "My hack of datahack from TATA Communications"
  :url "https://github.org/ifraixedes/hack-datahack14"
  :license {:name "MIT License"
            :url "https://github.org/ifraixedes/hack-datahack14/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.csv "0.1.2"]]
  :main ^:skip-aot datahack.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :repl-options {:host "127.0.0.1"
                 :port 5001})
