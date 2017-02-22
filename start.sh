#!/bin/sh

/usr/bin/java -Xmx128m -jar target/color-thief-1.0.0-jar-with-dependencies.jar 2>&1 | /usr/bin/tee -a log/color-thief.log

