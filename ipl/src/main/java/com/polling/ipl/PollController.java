package com.polling.ipl;

import com.polling.ipl.model.Poll;
import com.polling.ipl.model.PollRequest;
import com.polling.ipl.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Arrays;

@RestController
public class PollController {

    @Autowired
    PollRepo repo;

    @PostMapping("/addVote")
    public void addVote(@RequestBody PollRequest pollRequest){
        String team = pollRequest.getTeam();
        String name = pollRequest.getName();

        if(!repo.existsByTeamIgnoreCase(team)) {
            Poll poll = new Poll();
            poll.setTeam(team);
            poll.setVotes(new String[]{name});
            repo.save(poll);
        }
        else{
            Poll existingPoll = repo.findByTeamIgnoreCase(team);
            String[] existingVotes = existingPoll.getVotes();
            String[] newVotes = Arrays.copyOf(existingVotes, existingVotes.length + 1);
            newVotes[newVotes.length - 1] = name;
            existingPoll.setVotes(newVotes);
            repo.save(existingPoll);
        }
    }
}
