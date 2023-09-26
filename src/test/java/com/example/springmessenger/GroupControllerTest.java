package com.example.springmessenger;

import com.example.springmessenger.controller.GroupController;
import com.example.springmessenger.dto.EditGroupRequest;
import com.example.springmessenger.model.Group;
import com.example.springmessenger.service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GroupControllerTest {

    @Mock
    private GroupService groupService;

    @InjectMocks
    private GroupController groupController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    public void testGetGroupById() throws Exception {
        Group group = new Group();
        group.setId(1L);
        group.setName("Test Group");

        when(groupService.getById(1L)).thenReturn(group);

        mockMvc.perform(get("/groups/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Group"));
    }

    @Test
    public void testCreateGroup() throws Exception {
        EditGroupRequest request = new EditGroupRequest();
        request.setName("New Group");
        request.setMembers(Set.of());

        Group newGroup = new Group();
        newGroup.setId(1L);
        newGroup.setName("New Group");

        groupService.save(newGroup);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/groups/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"New Group\", \"members\": [] }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("New Group"));


       verify(groupService, times(1)).save(newGroup);
    }

    @Test
    public void testUpdateGroup() throws Exception {
        EditGroupRequest request = new EditGroupRequest();
        request.setName("Updated Group");
        request.setMembers(Set.of());

        Group group = new Group();
        group.setId(1L);
        group.setName("Test Group");

        when(groupService.getById(1L)).thenReturn(group);

        mockMvc.perform(patch("/groups/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated Group\", \"members\": [] }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Group"));
    }
}
