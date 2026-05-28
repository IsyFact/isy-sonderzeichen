#!/bin/bash
# Shell-Skript: Image bauen und Antora mit dem lokalen Playbook ausführen

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Running Antora..."
docker-compose -f "$SCRIPT_DIR/docker-compose.yml" run --rm antora
if [ -f "$SCRIPT_DIR/build/site/index.html" ]; then
    echo "Build abgeschlossen. Ausgabe: $SCRIPT_DIR/build/site"
else
    echo "Build beendet. Prüfe die Ausgabe oben auf Fehler."
fi
