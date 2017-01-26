(ns tenzing3.app
  "Example ClojureScript client application."
  (:require [clojure.string :as string]
            [weasel.repl :as repl] ;; see NOTE below
            ))

(enable-console-print!)

(def baz
  "Example CLJS var"
  {:b 456})

(println "evaluating app.cljs, baz:" baz)

(defn init
  "This initialization function will be called whenever this file is edited."
  []
  (println "updating HTML in #'init")
  (let [c (.. js/document (createElement "DIV"))]
    (aset c "innerHTML" (str "<p>i'm dynamically created at " (js/Date) "</p>"))
    (.. js/document (getElementById "container") (appendChild c))))

;; Set the value below to true if using IntelliJ/Cursive (otherwise set to false)
;; see NOTE below
(def cursive? true)

(defonce weasel? (atom cursive?)) ;; see NOTE below

(when-not @weasel?  ;; see NOTE below
  ;; Connect via Weasel to nREPL for development
  (println "connecting to Weasel..")
  (repl/connect "ws://localhost:9001")
  (reset! weasel? true))

;; NOTE on explicitly calling repl/connect
;; Normally the call to repl/connect should be done automatically
;; by boot-reload (especially if the reload  task is called
;; with :ws-port 9001). However this does not seem to work in practice with CIDER.
;; Instead there is an error in the JavaScript console:
;;    Error: No method in multimethod 'adzerk.boot-reload.client/handle' for dispatch value:
;; Which suggests that when handle is called
;; https://github.com/adzerk-oss/boot-reload/blob/master/src/adzerk/boot_reload/client.cljs#L35
;; that (:type msg) is nil. (hey, shouldn't there be a default multimethod??)
;; Perhaps this is a timing issue?
