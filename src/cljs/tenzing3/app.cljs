(ns tenzing3.app
  "Example ClojureScript client application."
  (:require [clojure.string :as string]))

(enable-console-print!)

(println "evaluating app.cljs")

(defn init
  "This initialization function will be called whenever this file is edited."
  []
  (println "updating HTML in #'init")
  (let [c (.. js/document (createElement "DIV"))]
    (aset c "innerHTML" "<p>i'm dynamically created</p>")
    (.. js/document (getElementById "container") (appendChild c))))
