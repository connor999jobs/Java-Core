package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.file.PathUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesImpl implements Files{
    @Override
    public boolean contentEquals(File file1, File file2) throws IOException {
        if (file1 == null || file2 == null){
            throw new FileNotFoundException();
        }
        if (!file1.isFile() || !file2.isFile()) {
            throw new IllegalArgumentException();
        }
        return PathUtils.fileContentEquals(file1.toPath(), file2.toPath());
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {
        if (sourceDir == null || destinationDir == null){
            throw new FileNotFoundException();
        }
        if (!sourceDir.isFile() || !destinationDir.isFile()) {
            throw new IllegalArgumentException();
        }
        FileUtils.copyDirectoryToDirectory(sourceDir,destinationDir);

    }

    @Override
    public String toString(URL url, Charset encoding) throws IOException {
        if (url == null || encoding == null){
            throw new FileNotFoundException();
        }

        StringBuilder string = new StringBuilder();
        URLConnection urlConn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), encoding));
        String line = "";

        while ((line = reader.readLine()) != null) {
            string.append(line).append("\n");
        }
        reader.close();
     
        return string.toString();
    }

    @Override
    public String toString(InputStream input, Charset charset) throws IOException {
        if (input == null){
            throw new RuntimeException();
        }
        return IOUtils.toString(input,charset);
    }

    @Override
    public byte[] toByteArray(URL url) throws IOException {
        if (url == null){
            throw new RuntimeException();
        }
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        return bufferedReader.readLine().getBytes();
    }

    @Override
    public String normalize(String fileName) {
        if (fileName == null) {
            throw new RuntimeException();
        }

        Path path = Paths.get(fileName);
        Path normalizedPath  = path.normalize();

        return normalizedPath.toString();
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        if (file == null) {
            throw new RuntimeException();
        }

        List<String> readLines;
        readLines = FileUtils.readLines(file,charset);
        return readLines;
    }

    @Override
    @SneakyThrows
    public boolean isEmptyDirectory(File directory) {
        if (directory == null) {
            throw new RuntimeException();
        }
        return FileUtils.isEmptyDirectory(directory);
    }
}
