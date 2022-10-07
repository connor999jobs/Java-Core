package com.knubisoft.tasks.algorithm.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonTasksImpl implements JsonTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseJson(String json) {
        if (json.isEmpty()){
            throw new RuntimeException();
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());

        return mapper.readValue(json, ModelRoot.class);
    }

    @Override
    @SneakyThrows
    public List<Integer> getAllIds(String json) {
        if (json.isEmpty()){
            throw new RuntimeException();
        }
        List<Integer> getAllIds = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        ModelRoot root = mapper.readValue(json, ModelRoot.class);
        int count = 0;
        for (ModelRoot.Item id : root.items){
            getAllIds.add(count, id.id);
            count++;
        }
        return getAllIds;
    }

    @Override
    @SneakyThrows
    public List<String> getNameWithIdMoreThan1(String json) {
        if (json.isEmpty()){
            throw new RuntimeException();
        }
        List<String> getAllIds = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        ModelRoot root = mapper.readValue(json, ModelRoot.class);
        for (ModelRoot.Item id : root.items){
            if (id.id > 1){
                getAllIds.add(id.name);
            }
        }
        return getAllIds;
    }

    @Override
    public List<Map<String,String>> getAllItems(String json) {
        return null;
    }

}
