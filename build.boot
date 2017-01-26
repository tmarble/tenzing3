;; Copyright © 2017 Tom Marble
;;
;; This software is licensed under the terms of the
;; MIT license which can be found in
;; the file LICENSE at the root of this distribution.


(set-env!
 :source-paths    #{"src/cljs" "src/clj"}
 :resource-paths  #{"resources"}
 :dependencies '[[org.clojure/clojure       "1.8.0"]
                 [adzerk/boot-cljs          "1.7.228-2"  :scope "test"]
                 [adzerk/boot-cljs-repl     "0.3.3"      :scope "test"]
                 [adzerk/boot-reload        "0.5.0"      :scope "test"]
                 [pandeiro/boot-http        "0.7.6"      :scope "test"
                  :exclusions [org.clojure/clojure]]
                 [com.cemerick/piggieback   "0.2.1"      :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12"     :scope "test"]
                 [weasel                    "0.7.0"      :scope "test"]
                 [org.clojure/clojurescript "1.9.293"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]])

;; (task-options!
;;   serve {:dir "target"})

(deftask build-cljs
  "Build ClojureScript in the target/ directory"
  []
  (comp
    (notify
      :visual true
      :title "CLJS"
      :messages {:success "http://localhost:3000 is ready"})
    (speak)
    (cljs)
    ;; (target :dir #{"target"})
    ))

(deftask run
  "Run ClojureScript application on http://localhost:3000"
  []
  (comp (serve)
        (watch)
        (reload)
        (cljs-repl)
        (build-cljs)))

(deftask production
  "Example task to change ClojureScript options for production"
  []
  (task-options!
    cljs {:optimizations :advanced})
  identity)

(deftask development
  "Example task to change ClojureScript options for development"
  []
  (task-options!
    cljs {:optimizations :none :source-map true}
    reload {;; :ws-port 9001
            :on-jsload 'tenzing3.app/init}
    repl {:port 8082
          :middleware '[cemerick.piggieback/wrap-cljs-repl]})
  identity)

;; This will start an nREPL server on 8082 that a remote IDE
;; can connect to for the CLJS REPL.
(deftask cljs-dev
  "Starts CLJS nREPL"
  []
  (comp (development)
        (run)))

;; This will start an nREPL server on 8081 that a remote IDE
;; can connect to for the CLJ REPL.
(deftask clj-dev
  "Starts CLJ nREPL"
  []
  (comp
    (repl
      :port 8081
      :server true
      :init "src/clj/tenzing3/server.clj"
      :init-ns 'tenzing3.server)
    (wait)))

;; For Emacs if you Customize your Cider Boot Parameters to 'cider-boot'
;; then this task will be invoked upon M-x cider-jack-in-clojurescript
;; which is on C-c M-J
;; CIDER will then open two REPL buffers for you, one for CLJS
;; and another for CLJ. FFI:
;; https://cider.readthedocs.io/en/latest/up_and_running/#clojurescript-usage

(deftask cider-boot
  "Cider boot params task"
  []
  (comp
    (cider)
    (cljs-dev)))
