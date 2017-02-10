(set-env!
  :resource-paths #{"src"}
  :dependencies '[
                  [hoplon                                   "6.0.0-alpha17"]
                  [adzerk/boot-cljs                         "1.7.228-2"]
                  [rowtr/form                               "0.2.2"]
                  [org.clojure/clojurescript                "1.9.293"]
                  [hoplon/castra                            "3.0.0-alpha7"]
                  [cljsjs/moment                            "2.9.0-1"]
                  [cljsjs/stripe                            "2.0-0"]
                  [adzerk/env                               "0.2.0"]
                  [adzerk/cljs-console                      "0.1.1"]
                  ])

(require
 '[adzerk.env               :as    env]
  '[adzerk.boot-cljs         :refer [cljs]]
  '[tailrecursion.boot-jetty :refer [serve]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]])


(task-options!
  pom    {:project 'rowtr/hoplon-stripe
          :version "0.1.0"
          :description "stripe component for hoplon apps"}
  serve  {:port 3333}
  speak  {:theme "woodblock"}
  cljs   {:source-map true}
  hoplon {:pretty-print true :manifest true})


(task build-jar []
  "build the jar"
  (comp
    (pom)
    (jar)))

(task install-jar[]
  "build the jar"
  (comp
    (build-jar)
    (install)))

(task push-jar[]
  "build the jar"
  (comp
    (build-jar)
    (push)))
