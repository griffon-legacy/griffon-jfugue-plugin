
Play MIDI and WAV files with JFugue
-----------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jfugue](http://artifacts.griffon-framework.org/plugin/jfugue)


This plugin allows applications to play MIDI and WAV files using [JFugue][1].

Usage
-----

This plugin is just a convenient way to obtain the JFugue libraries as they are not hosted in a publicly available Maven repository.
You would typically instantiate an object of type `org.jfuguePlayer` and set the tunes you want to play. Visit [JFugue's website][1]
for more information on the API, examples and [The Complete Guide to JFugue][2]

### Example

Here's an example of setting a very simple tune that will be played when the application starts. The same tune but in reverse will be
played when the application shutdowns itself. Pay attention to threading concerns, in this example the application will wait until
the tunes have been played before continuing with the next step.

Place the following code inside __griffon-app/conf/Events.groovy__

        import org.jfugue.Pattern
        import org.jfugue.Player

        TUNE = 'C D E F G A B'

        onBootstrapStart = { app ->
            app.bindings.player = new Player()
            app.bindings.player.play TUNE
        }

        onShutdownStart = { app ->
            app.bindings.player.play TUNE.reverse()
        }

[1]: http://www.jfugue.org/
[2]: http://www.jfugue.org/book.html

