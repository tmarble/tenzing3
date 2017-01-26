# Running tenzing3 with CIDER

The Prerequisite setup is in the [README](../README.md)
(See also running with [Cursive](Cursive.md))

For background on using ClojureScript in CIDER see
[ClojureScript usage](https://cider.readthedocs.io/en/latest/up_and_running/#clojurescript-usage).

## Configure Emacs

Make sure you have your [CIDER](https://github.com/clojure-emacs/cider)
installed in Emacs (e.g. by adding it from the MELPA package repository).

Now you can customize your CIDER configuration. Start by
entering `M-x customize`, enter "cider" in the search box,
and press **Search**.

1. Make sure the **Cider Boot Command** has the fully qualified path to where
   you installed **boot** (usually in `~/bin`).
2. Set your **Cider Boot Parameters** to `cider-boot` <br/>
   When you `cider-jack-in` this will call the `cider-boot` task
   in your `build.boot` file. If, for other projects, you don't
   need to do any extra steps prior to running the `cider` task
   itself (from `profile.boot`) then you can just make a simple
   task like this:
```clojure
(deftask cider-boot
  "Cider boot params task"
  []
  (cider))
 ```
 3. Set **Cider Cljs Lein Repl** to `Weasel`
 4. For all the variables you changed be sure to click on **State**
    and select "Save for future sessions"

## Visit app.cljs

Visit [app.cljs](https://github.com/tmarble/tenzing3/blob/master/src/cljs/tenzing3/app.cljs#L25) in a buffer and change
`(def cursive? true)`
to
`(def cursive? false)`

## Start CLJS REPL

Now you're ready to `M-x cider-jack-in-clojurescript` (on **C-c M-J**).

You will see a message `Starting nREPL server via ...` which
will take a little while to run and set things up...

You will then see the question (because we have both `build.boot` and `project.clj` files), then enter "boot":

```
**Which command should be used (default lein):** boot
```

In the buffer **cider-repl CLJS tenzing3** you will see

```
boot.user> << started Weasel server on ws://127.0.0.1:9001 >>
<< waiting for client to connect ...
```

You will then see this question and answer "n":
```
Visit 'http://localhost:3000' in a browser? (y or n) n
```

Because we do want to visit that web page, but at this point
not all the ClojureScript files have been compiled (so let's
be patient)!

When everything is ready you should hear an audible sound
and see a notification `CLJS: http://localhost:3000 is ready`

*Now* you can open (or reload) [http://localhost:3000](http://localhost:3000)

In your browser JavaScript console you should see:

```
Opened Websocket REPL connection  repl.js:168:1
Reload websocket connected.
```

## In the CLJS REPL

In the buffer **cider-repl CLJS tenzing3** you can change the
namespace for `app.cljs` like this:

```
boot.user> (in-ns 'tenzing3.app)
```

Now visit the `app.cljs` buffer and enter `M-x cider-eval-buffer`: this
will evaluate the file so all the symbols are defined in the REPL. At
this point you can evaluate a simple symbol:

```
tenzing3.app> baz
{:b 456}
tenzing3.app>
```

Now in `app.cljs` if you change the definition of `baz` to `{:b 457}`
and save the file you will notice that browser is updated automatically!
Whenever the browser is reloaded you'll see a new line like
`i'm dynamically created at Thu Jan 26 2017 10:43:36 GMT-0600 (CST)`

You can also print directly to the JavaScript console (where
you should see 123 appear):

```
tenzing3.app> (println 123)
nil
tenzing3.app>
```
## In the CLJ REPL

In the buffer **cider-repl tenzing3** you can change the
namespace for `server.clj` like this:

```
boot.user> (in-ns 'tenzing3.server)
```

Now visit the `server.clj` buffer and enter `M-x cider-eval-buffer`: this
will evaluate the file so all the symbols are defined in the REPL. At
this point you can evaluate a simple symbol and call a function:

```
tenzing3.server> bar
{:a 123}
tenzing3.server> (foo bar)
foo with args: ({:a 123})
nil
tenzing3.server>
```

## Quitting both REPL's

When you are done go to the **cider-repl tenzing3** buffer
and enter `M-x cider-quit` (on **C-c C-q**).

You will be asked (and can answer "y"):

```
Also kill server process and buffer? (y or n) y
```

You can now simply kill the **cider-repl CLJS tenzing3** buffer.
