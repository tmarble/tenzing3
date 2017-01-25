(ns tenzing3.app
  (:require [weasel.repl :as repl]))

(defn init []
  (let [c (.. js/document (createElement "DIV"))]
    (aset c "innerHTML" "<p>i'm dynamically created</p>")
    (.. js/document (getElementById "container") (appendChild c))))

;; (repl/connect "ws://localhost:9001")
