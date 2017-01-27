# Running tenzing3 with Cursive

The Prerequisite setup is in the [README](../README.md)
(See also running with [CIDER](CIDER.md))

## Background for Cursive users

Normally Cursive works with **leiningen** so in order for a **boot**
project to operate you first need to create a `project.clj` file.
In **tenzing3** this has already been done for you. NOTE: that
the **lein-generate** task is part of the proposed `profile.boot` file.

For further information
* https://github.com/boot-clj/boot/wiki/For-Cursive-Users
* https://github.com/boot-clj/boot/wiki/Boot-for-Leiningen-Users
* https://github.com/boot-clj/boot/wiki/Using-Boot-in-a-Leiningen-Project
* https://cursive-ide.com/userguide/repl.html

## Start Cursive and import the tenzing3 project

1. Click **Import Project** ![IntelliJ startup screen](images/intellij.png)
2. Choose **Import Project from external model** and select **Leiningen** ![Import lein](images/import-lein.png)
3. Set the **Root Directory** to where you cloned **tenzing3** ![root dir](images/root-dir.png)
4. Select Leiningen project to import ![lein import](images/lein-import.png)
5. Select the project SDK (IDE SDK)  ![ide sdk](images/ide-sdk.png)
6. Enter a project name:  ![project name](images/project-name.png)
7. Accept the warning about `.idea` <br/> ![.idea warning](images/idea-warning.png)


Now the project should be imported:
![project ready](images/project-ready.png)

## Add CLJS REPL configuration

Under the arrow on the upper right select "Edit Configurations...":

![edit configurations](images/edit-config.png)

Click the "+" symbol and add a Clojure, Remote REPL:

![add clojure remote](images/add-clojure-remote.png)

Set the parameters for the CLJS REPL:
* **Name:** CLJS REPL
* **Host:** localhost
* **Port:** 8082
* Remove task before launch (click Build, then "-")
![cljs repl config](images/cljs-repl-config.png)

## Add CLJ REPL configuration

Repeat as above, then click the "+" symbol and add a Clojure, Remote REPL:

Set the parameters for the CLJ REPL:
* **Name:** CLJ REPL
* **Host:** localhost
* **Port:** 8081
* Remove task before launch (click Build, then "-")

## Open a Terminal, start the CLJS nREPL

Hover over the icon on the lower left and click on "Terminal":

![terminal](images/terminal.png)

Start the CLJS nREPL server by typing `boot cljs-dev`:

![CLJS nREPL](images/cljs-nrepl.png)

When all the ClojureScript files have been compiled you
should hear an audible notification and see the following
in the terminal:
![CLJS ready](images/cljs-ready.png)

## Launch the browser

*Now* you can open (or reload) [http://localhost:3000](http://localhost:3000)
![browser1](images/browser1.png)

In your browser JavaScript console you should see:

```
Reload websocket connected.
```

## Start the CLJS REPL

In the configuration menu on the upper right select "CLJS REPL" and
press the "Play" (triangle) icon:

![start cljs](images/start-cljs.png)

You will now see a new CLJS REPL window. *NOTE:* the input area
is just below this window. In the input area type `(start-repl)`
and press return.
![start repl](images/start-repl.png)

## Visit app.cljs

Open the `app.cljs` file by clicking in the `src/cljs/tenzing3` directory
and then in the main application menu select: **Tools | REPL | Load file in REPL**

This will evaluate the file so all the symbols are defined in the REPL. At
this point you can change the namespace to `tenzing3.app` by entering in the
input area: `(in-ns 'tenzing3.app)` and then evaluate a simple symbol: `baz`.

You should see `{:b 456}` in the CLJS REPL.

Now in `app.cljs` if you change the definition of `baz` to `{:b 457}`
and save the file (or let it autosave after a second or two) you will
notice that browser is updated automatically!
Whenever the browser is reloaded you'll see a new line like
`i'm dynamically created at Thu Jan 26 2017 10:43:36 GMT-0600 (CST)`

![browser3](images/browser3.png)

You can also print directly to the JavaScript console (where
you should see 123 appear) by entering `(println 123)` in the
REPL input area.

## Start the CLJ REPL

In a native terminal window start the CLJ nREPL server by entering:

```
boot clj-dev
```
![boot clj-dev](images/clj-dev.png)

## Visit server.clj

Open the `server.clj` file by clicking in the `src/clj/tenzing3` directory
and then in the main application menu select: **Tools | REPL | Load file in REPL**

This will evaluate the file so all the symbols are defined in the REPL. At
this point you can change the namespace to `tenzing3.server` by entering in the
input area: `(in-ns 'tenzing3.server)`and then evaluate a simple symbol: `bar`.

You should see `{:a 123}` in the CLJ REPL.

Then you can a function by typing `(foo bar)` in the REPL input area:

![foo bar](images/foo-bar.png)

Now you can click back and forth between the CLJS REPL and the CLJ REPL!

## Quitting both REPL's

When you are done you can click on the square "Stop" button in each
of the REPL windows.

Then type ^C in each of the terminal windows to stop the nREPL processes.
