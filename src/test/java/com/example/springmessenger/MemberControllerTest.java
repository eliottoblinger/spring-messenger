package com.example.springmessenger;

import com.example.springmessenger.controller.MemberController;
import com.example.springmessenger.dto.EditMemberRequest;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.service.MemberService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MemberControllerTest {

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member member = new Member();
        member.setId(1L);
        member.setCustomName("Test Member");

        when(memberService.getById(1L)).thenReturn(member);

        mockMvc.perform(get("/members/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customName").value("Test Member"));
    }

    @Test
    public void testCreateMember() throws Exception {
        EditMemberRequest request = new EditMemberRequest();
        request.setCustomName("New Member");

        Member newMember = new Member();
        newMember.setId(1L);
        newMember.setCustomName("New Member");

        memberService.save(newMember);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/members/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customName\": \"New Member\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customName").value("New Member"));

        verify(memberService, times(1)).save(newMember);
    }

    @Test
    public void testUpdateMember() throws Exception {
        EditMemberRequest request = new EditMemberRequest();
        request.setCustomName("Updated Member");

        Member member = new Member();
        member.setId(1L);
        member.setCustomName("Test Member");

        when(memberService.getById(1L)).thenReturn(member);

        mockMvc.perform(patch("/members/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"customName\": \"Updated Member\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customName").value("Updated Member"));
    }
}
