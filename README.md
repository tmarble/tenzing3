# tenzing3

Clojure and ClojureScript are really fun for development, yet
sometimes getting the tooling set up properly can be delicate.

The purpose of this repository is to give developers an example
and quick Out-of-the-box experience in setting up dual
CLJS + CLJ REPLs with [Cursive](https://cursive-ide.com/)
and/or [CIDER](https://github.com/clojure-emacs/cider) when using
[boot](http://boot-clj.com/).

## Prerequisite setup

1. Clone this repo
2. Ensure you have [boot installed](https://github.com/boot-clj/boot#install)
3. Verify your **boot** configuration. The files in `Boot/` can be copied (or used to update) the ones in `~/.boot`:
  * `boot.properties`
  * `profile.boot`

## Make dual CLJS + CLJ REPL connections

Continue setting up in one (or both) of...

* [Cursive](doc/Cursive.md)
* [CIDER](doc/CIDER.md)

## Next Steps

Apply this approach to your Clojure web project where you can
have an interactive REPL in the browser _and_ the server
at the same time!

## Expert help needed

There's an unfortunate workaround I've had to use to convince
Weasel to connect properly with CIDER.  See the note in `app.cljs`
for details. Let me know if you can help fix this!

## Acknowledgments

Major thanks go to [Colin Fleming](https://twitter.com/colinfleming),
the lead [Cursive developer](https://cursive-ide.com/), who spent
a ton of time with me on [Clojurians Slack](http://clojurebridge-minneapolis.github.io/slack.html) **#cursive** to help me work out the Cursive integration.

Thanks to [Bozhidar Batsov](https://twitter.com/bbatsov), Mr. `M-x`
of [CIDER](https://github.com/clojure-emacs/cider) making sure
that [Emacs Rocks](https://twitter.com/EmacsRocks)!

Thanks to [Martin Klepsch](https://twitter.com/martinklepsch) for
creating the [tenzing](https://github.com/martinklepsch/tenzing)
ClojureScript application template using Boot on which **tenzing3**
is based.

And, of course, thanks to the Clojure community for being open,
willing to help newbies and wicked smart!

## Copyright and license

Copyright © 2017 Tom Marble

Licensed under the [MIT License](http://opensource.org/licenses/MIT) [LICENSE](LICENSE)
