/*
 * griffon-jfugue - a JFugue plugin for Griffon
 * Copyright (C) 2012  Andres Almiray
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */

/**
 * @author Andres Almiray
 */
class JfugueGriffonPlugin {
    // the plugin version
    String version = '0.1'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [:]
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'GNU Lesser General Public License 2.1'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jfugue-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Play MIDI and WAV files with JFugue'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
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
'''
}
