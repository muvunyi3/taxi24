package org.taxi24.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.taxi24.api.controller.DriversController;
import org.taxi24.api.model.Drivers;
import org.taxi24.api.service.DriversService;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringTestConfig.class)
public class DriversServiceUnitTest {
 
	   private MockMvc mockMvc;
	   @Mock
	    private DriversService driversService;

	    @InjectMocks
	    private DriversController driversController;

	    @Before
	    public void setUp() throws Exception {
	        mockMvc = MockMvcBuilders.standaloneSetup(driversController)
	                .build();
	    }
	    @Test
	    public void testHelloWorld() throws Exception {
	    	List<Drivers> drList = null;
	        when(driversService.list()).thenReturn(drList);

	        mockMvc.perform(get("/api/drivers"))
	                .andExpect(status().isOk())
	                .andExpect(content().json("{'data':[{'useRegEx':'false','hosts':'drivers'}]}"));

	        verify(driversService).list();
	    }
	    /*@Test
	    public void testPost() throws Exception {
	        String json = "{\n" +
	                "  \"title\": \"Greetings\",\n" +
	                "  \"value\": \"Hello World\"\n" +
	                "}";
	        mockMvc.perform(post("/hello/post")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(json))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
	                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
	                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
	    }*/

	   /*
    @Autowired
    private EmployeeService empService;
    @Autowired
    private RestTemplate restTemplate;
 
    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();
 
    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
     
    @Test                                                                                         
    public void givenMockingIsDoneByMockRestServiceServer_whenGetIsCalled_thenReturnsMockedObject()() {   
        Employee emp = new Employee("E001", "Eric Simmons");
        mockServer.expect(ExpectedCount.once(), 
          requestTo(new URI("http://localhost:8080/employee/E001")))
          .andExpect(method(HttpMethod.GET))
          .andRespond(withStatus(HttpStatus.OK)
          .contentType(MediaType.APPLICATION_JSON)
          .body(mapper.writeValueAsString(emp))
        );                                   
                        
        Employee employee = empService.getEmployee(id);
        mockServer.verify();
        Assert.assertEquals(emp, employee);                                                        
    }*/
}
