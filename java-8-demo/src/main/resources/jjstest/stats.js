var path = java.nio.file.Paths.get("src/main/resources/jjstest/sales.txt");
var lines = java.nio.file.Files.lines(path);
print("Total: " + lines.mapToDouble(function(s) {return parseFloat(s)})
        .sum());

// lines stream has been closed, so we need to re-open it
lines = java.nio.file.Files.lines(path);
print("Average: " + lines.mapToDouble(function(s) {return parseFloat(s)})
        .average().getAsDouble());