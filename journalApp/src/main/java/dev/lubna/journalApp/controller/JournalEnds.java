package dev.lubna.journalApp.controller;


import dev.lubna.journalApp.model.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEnds {

    private Map<Long , JournalEntry> journalEntryMap = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getJournalEntry(){
        return new ArrayList<>(journalEntryMap.values());
    }

    @GetMapping("id/{pathId}")
    public  JournalEntry getEntryById(@PathVariable Long pathId){
        return  journalEntryMap.get(pathId);
    }

    @PostMapping
    public  boolean postJournalEntry(@RequestBody JournalEntry entry){

        journalEntryMap.put(entry.getId() , entry);
        return  true;

    }

    @PutMapping("id/{pathId}")
    public  boolean updateJournalEntryById(@RequestBody JournalEntry entry , @PathVariable long pathId ){
        journalEntryMap.put(pathId, entry);
        return  true ;
    }

    @DeleteMapping("id/{pathId}")
    public String deleteJournalEntryById(@PathVariable long pathId){
        journalEntryMap.remove(pathId);
        return  pathId + "is Deleted !";
    }

}
