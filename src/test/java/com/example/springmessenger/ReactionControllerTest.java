package com.example.springmessenger;

import com.example.springmessenger.controller.ReactionController;
import com.example.springmessenger.dto.EditReactionRequest;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.model.Reaction;
import com.example.springmessenger.service.MessageService;
import com.example.springmessenger.service.ReactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReactionControllerTest {

    @Mock
    private ReactionService reactionService;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private ReactionController reactionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reactionController).build();
    }

    @Test
    public void testGetReactionById() throws Exception {
        Reaction reaction = new Reaction();
        reaction.setId(1L);
        reaction.setContent("Test Reaction");

        when(reactionService.getById(1L)).thenReturn(reaction);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/reaction/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Test Reaction"));
    }

    @Test
    public void testCreateReaction() throws Exception {
        EditReactionRequest request = new EditReactionRequest();
        request.setContent("New Reaction");

        Member member = new Member();
        Message message = new Message();

        Reaction newReaction = new Reaction();
        newReaction.setId(1L);
        newReaction.setContent("New Reaction");
        newReaction.setMember(member);
        newReaction.setMessage(message);

        when(messageService.getById(1L)).thenReturn(message);

        reactionService.save(newReaction);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/reaction/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\": \"New Reaction\", \"member\": {}, \"message\": {} }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("New Reaction"));

        verify(reactionService, times(1)).save(newReaction);
    }

    @Test
    public void testDeleteReaction() throws Exception {
        Reaction reaction = new Reaction();
        reaction.setId(1L);
        reaction.setContent("Test Reaction");

        when(reactionService.getById(1L)).thenReturn(reaction);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/reaction/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(reactionService, times(1)).delete(reaction);
    }
}
