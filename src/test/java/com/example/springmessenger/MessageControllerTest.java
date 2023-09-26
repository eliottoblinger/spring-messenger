package com.example.springmessenger;

import com.example.springmessenger.controller.MessageController;
import com.example.springmessenger.dto.EditMessageRequest;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    public void testGetMessageById() throws Exception {
        Message message = new Message();
        message.setId(1L);
        message.setContent("Test Message");

        when(messageService.getById(1L)).thenReturn(message);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/messages/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Test Message"));
    }

    @Test
    public void testCreateMessage() throws Exception {
        EditMessageRequest request = new EditMessageRequest();
        request.setContent("New Message");

        Message newMessage = new Message();
        newMessage.setId(1L);
        newMessage.setContent("New Message");

        messageService.save(newMessage);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/messages/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\": \"New Message\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("New Message"));

        verify(messageService, times(1)).save(newMessage);
    }

    @Test
    public void testDeleteMessage() throws Exception {
        Message message = new Message();
        message.setId(1L);
        message.setContent("Test Message");

        when(messageService.getById(1L)).thenReturn(message);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/messages/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(messageService, times(1)).delete(message);
    }
}
