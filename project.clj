(defproject datahack "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.csv "0.1.2"]]
  :main ^:skip-aot datahack.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :repl-options {:host "127.0.0.1"
                 :port 5001})
