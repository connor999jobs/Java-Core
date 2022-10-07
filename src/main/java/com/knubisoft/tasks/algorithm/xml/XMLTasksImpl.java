package com.knubisoft.tasks.algorithm.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class XMLTasksImpl implements XMLTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseXML(String xml) {
        if (xml == null){
            throw new RuntimeException();
        }

        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(xml, ModelRoot.class);
    }

    @Override
    @SneakyThrows
    public List<Integer> getAllIds(String xml) {
        if (xml.isEmpty()){
            throw new RuntimeException();
        }
        List<Integer> getAllIds = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();
        ModelRoot root = mapper.readValue(xml, ModelRoot.class);
        int count = 0;
        for (ModelRoot.Item id : root.items){
            getAllIds.add(count, id.id);
            count++;
        }
        return getAllIds;
    }

    @Override
    @SneakyThrows
    public List<String> getNameWithIdMoreThan1(String xml) {
        if (xml.isEmpty()){
            throw new RuntimeException();
        }
        List<String> getAllIds = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();
        ModelRoot root = mapper.readValue(xml, ModelRoot.class);
        for (ModelRoot.Item id : root.items){
            if (id.id > 1){
                getAllIds.add(id.name);
            }
        }
        return getAllIds;
    }

    @SneakyThrows
    private Object xpath(String xml, String expression, QName q) {
        return null;
    }

    private <T> List<T> apply(NodeList nodeList, Function<Node, T> tFunction){
        return null;
    }
}
