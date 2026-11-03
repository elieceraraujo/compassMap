package com.example.demo;

import com.example.demo.model.CodeProfile;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProfile;
import com.example.demo.model.RoadMap;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.RoadMapService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	//@Autowired
	//private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RoadMapService roadMapService;
	@Autowired
	private CustomerProfileService customerProfileService;

	@Test
	void contextLoads() {
	}

	@Test
	void findCustomerById (){

		Customer customerFound1 = customerService.getCustomerById("64c7be39-d974-419f-a766-a6063346676b");
		System.out.println("Customer found 1 : " + customerFound1 );

		Customer customerFound2 = customerService.getCustomerById("banana");
		System.out.println("Customer found 2 : " + customerFound2 );


	}

	@Test
	void deleteCustomerById(){

		customerService.deleteCustomer("8b4ca0f7-5de0-4ab2-a431-a849f158cd62");
	}


	@Test
	void javaFakerCreateObjects(){


		Faker faker = new Faker();

		//String name = faker.name().fullName(); // Miss Samanta Schmidt
		//String firstName = faker.name().firstName(); // Emory
		//String lastName = faker.name().lastName(); // Barton

		//String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

		//String titleBook = faker.book().title();

		Customer newCustomer = new Customer();

		for (int i= 0; i < 1000; i++){

			// id?
			newCustomer.setFirstName( faker.name().firstName()  );
			newCustomer.setLastName(  faker.name().lastName());

			customerService.createCustomer(newCustomer);
		}
	}

	@Test
	void customerProfileRoadMap() {

		List<RoadMap> roadMaps = CreateRoadmaps();
		List<CustomerProfile> customerProfiles = CreateProfiles();
		for (CustomerProfile customerProfile : customerProfiles) {

			List<RoadMap> filteredRoadMaps = roadMaps.stream()
					.filter(roadMap -> roadMap.getName().contains(customerProfile.getId()))
					.toList();

			customerProfile.setRoadMaps(filteredRoadMaps);
		}
		//roadMapService.saveAll(roadMaps);
		customerProfileService.saveAll(customerProfiles);

	}

	private List<RoadMap> CreateRoadmaps(){

		List<RoadMap> roadMaps = new ArrayList<>();
		// RM01
		RoadMap rm01 = RoadMap.builder()
				.id("RM01")
				.name("Backend Advanced (P01)")
				.description("Deepen backend skills: architecture, patterns and testing.")
				.stepsItemsSumary(Map.of(
						"1", "Design patterns",
						"2", "Clean architecture",
						"3", "REST APIs",
						"4", "Testing",
						"5", "Microservices"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM02
		RoadMap rm02 = RoadMap.builder()
				.id("RM02")
				.name("Frontend Advanced (P01)")
				.description("Master modern frontend frameworks and best practices.")
				.stepsItemsSumary(Map.of(
						"1", "Advanced JavaScript",
						"2", "TypeScript",
						"3", "React",
						"4", "State management",
						"5", "Frontend testing"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM03
		RoadMap rm03 = RoadMap.builder()
				.id("RM03")
				.name("Fullstack Advanced (P01)")
				.description("Build complete applications end to end.")
				.stepsItemsSumary(Map.of(
						"1", "Spring Boot",
						"2", "React",
						"3", "Databases",
						"4", "Authentication",
						"5", "Deployment"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM04
		RoadMap rm04 = RoadMap.builder()
				.id("RM04")
				.name("DevOps (P01)")
				.description("Automate build, test and deployment pipelines.")
				.stepsItemsSumary(Map.of(
						"1", "Linux",
						"2", "Docker",
						"3", "CI/CD",
						"4", "Kubernetes"
				))
				.steps(4)
				.completed(false)
				.build();

		// RM05
		RoadMap rm05 = RoadMap.builder()
				.id("RM05")
				.name("Mobile Advanced (P01)")
				.description("Go deeper into mobile app development.")
				.stepsItemsSumary(Map.of(
						"1", "Kotlin",
						"2", "Android architecture",
						"3", "Flutter",
						"4", "Mobile testing"
				))
				.steps(4)
				.completed(false)
				.build();

		// RM06
		RoadMap rm06 = RoadMap.builder()
				.id("RM06")
				.name("AI for Backend (P02)")
				.description("Use AI tools to speed up backend development.")
				.stepsItemsSumary(Map.of(
						"1", "AI coding assistants",
						"2", "Prompting for APIs",
						"3", "AI code review"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM07
		RoadMap rm07 = RoadMap.builder()
				.id("RM07")
				.name("AI for Frontend (P02)")
				.description("Generate and iterate UIs with AI tools.")
				.stepsItemsSumary(Map.of(
						"1", "AI UI generators",
						"2", "Prompting for components",
						"3", "AI refactoring"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM08
		RoadMap rm08 = RoadMap.builder()
				.id("RM08")
				.name("AI Fullstack Projects (P02)")
				.description("Ship full projects quickly with AI agents.")
				.stepsItemsSumary(Map.of(
						"1", "Project scaffolding with AI",
						"2", "AI agents",
						"3", "AI debugging",
						"4", "Deploy"
				))
				.steps(4)
				.completed(false)
				.build();

		// RM09
		RoadMap rm09 = RoadMap.builder()
				.id("RM09")
				.name("AI for DevOps (P02)")
				.description("Automate infrastructure tasks with AI.")
				.stepsItemsSumary(Map.of(
						"1", "AI shell assistants",
						"2", "AI for CI/CD",
						"3", "AI monitoring"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM10
		RoadMap rm10 = RoadMap.builder()
				.id("RM10")
				.name("AI APIs Integration (P02)")
				.description("Integrate LLM APIs into existing projects.")
				.stepsItemsSumary(Map.of(
						"1", "LLM APIs",
						"2", "RAG basics",
						"3", "AI integration"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM11
		RoadMap rm11 = RoadMap.builder()
				.id("RM11")
				.name("Backend from Scratch (P03)")
				.description("Learn backend programming from zero.")
				.stepsItemsSumary(Map.of(
						"1", "Logic",
						"2", "Java basics",
						"3", "OOP",
						"4", "SQL",
						"5", "First API"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM12
		RoadMap rm12 = RoadMap.builder()
				.id("RM12")
				.name("Frontend from Scratch (P03)")
				.description("Learn to build web pages from zero.")
				.stepsItemsSumary(Map.of(
						"1", "HTML",
						"2", "CSS",
						"3", "JavaScript basics",
						"4", "DOM",
						"5", "First website"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM13
		RoadMap rm13 = RoadMap.builder()
				.id("RM13")
				.name("Fullstack from Scratch (P03)")
				.description("First steps across frontend and backend.")
				.stepsItemsSumary(Map.of(
						"1", "Logic",
						"2", "HTML/CSS",
						"3", "JavaScript",
						"4", "Backend basics",
						"5", "First app"
				))
				.steps(5)
				.completed(false)
				.build();

		// RM14
		RoadMap rm14 = RoadMap.builder()
				.id("RM14")
				.name("Python from Scratch (P03)")
				.description("Learn programming fundamentals with Python.")
				.stepsItemsSumary(Map.of(
						"1", "Variables",
						"2", "Control flow",
						"3", "Functions",
						"4", "Data structures"
				))
				.steps(4)
				.completed(false)
				.build();

		// RM15
		RoadMap rm15 = RoadMap.builder()
				.id("RM15")
				.name("Data Structures Basics (P03)")
				.description("Core data structures and algorithms for beginners.")
				.stepsItemsSumary(Map.of(
						"1", "Arrays",
						"2", "Lists",
						"3", "Maps",
						"4", "Sorting"
				))
				.steps(4)
				.completed(false)
				.build();

		// RM16
		RoadMap rm16 = RoadMap.builder()
				.id("RM16")
				.name("Intro to Backend (P04)")
				.description("Understand what backend developers do.")
				.stepsItemsSumary(Map.of(
						"1", "What is a server",
						"2", "What is an API",
						"3", "What is a database"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM17
		RoadMap rm17 = RoadMap.builder()
				.id("RM17")
				.name("Intro to Frontend (P04)")
				.description("Understand how web interfaces are built.")
				.stepsItemsSumary(Map.of(
						"1", "How the web works",
						"2", "HTML/CSS overview",
						"3", "UX basics"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM18
		RoadMap rm18 = RoadMap.builder()
				.id("RM18")
				.name("Intro to Software Teams (P04)")
				.description("Learn how developer teams work.")
				.stepsItemsSumary(Map.of(
						"1", "Roles",
						"2", "Agile",
						"3", "Git overview"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM19
		RoadMap rm19 = RoadMap.builder()
				.id("RM19")
				.name("Intro to DevOps & Cloud (P04)")
				.description("Overview of cloud and deployment concepts.")
				.stepsItemsSumary(Map.of(
						"1", "What is the cloud",
						"2", "Deployment overview",
						"3", "Costs"
				))
				.steps(3)
				.completed(false)
				.build();

		// RM20
		RoadMap rm20 = RoadMap.builder()
				.id("RM20")
				.name("Intro to AI (P04)")
				.description("Understand AI concepts and their impact.")
				.stepsItemsSumary(Map.of(
						"1", "What is AI",
						"2", "LLMs overview",
						"3", "AI use cases"
				))
				.steps(3)
				.completed(false)
				.build();

		roadMaps.add(rm01);
		roadMaps.add(rm02);
		roadMaps.add(rm03);
		roadMaps.add(rm04);
		roadMaps.add(rm05);
		roadMaps.add(rm06);
		roadMaps.add(rm07);
		roadMaps.add(rm08);
		roadMaps.add(rm09);
		roadMaps.add(rm10);
		roadMaps.add(rm11);
		roadMaps.add(rm12);
		roadMaps.add(rm13);
		roadMaps.add(rm14);
		roadMaps.add(rm15);
		roadMaps.add(rm16);
		roadMaps.add(rm17);
		roadMaps.add(rm18);
		roadMaps.add(rm19);
		roadMaps.add(rm20);

		return roadMaps;
	}

	private List<CustomerProfile> CreateProfiles(){
		// P01
		CustomerProfile p01 = CustomerProfile.builder()
				.id("P01")
				.codeProfile(CodeProfile.ARCHITECT)
				.name("Improve programming skills")
				.description("Developers who already know how to code and want to go deeper (architecture, design patterns, testing, frameworks, etc.)")
				.goal("Improve programming skills")
				.build();

		// P02
		CustomerProfile p02 = CustomerProfile.builder()
				.id("P02")
				.codeProfile(CodeProfile.ARCHITECT)
				.name("Use AI to create projects")
				.description("People who already know programming and only want to boost productivity with AI tools, without going deeper into code")
				.goal("Use AI to create projects")
				.build();

		// P03
		CustomerProfile p03 = CustomerProfile.builder()
				.id("P03")
				.codeProfile(CodeProfile.BEGINNER)
				.name("Starting from scratch in programming")
				.description("Absolute beginners who want to really learn programming: fundamentals, logic, data structures and a first language")
				.goal("Starting from scratch in programming")
				.build();

		// P04
		CustomerProfile p04 = CustomerProfile.builder()
				.id("P04")
				.codeProfile(CodeProfile.NON_DEVELOPER)
				.name("General introductory course")
				.description("Product managers, designers, entrepreneurs or students from other areas who just want to understand what developers do")
				.goal("General introductory course")
				.build();

		List<CustomerProfile> customerProfiles = new ArrayList<>();
		customerProfiles.add(p01);
		customerProfiles.add(p02);
		customerProfiles.add(p03);
		customerProfiles.add(p04);

		return customerProfiles;
	}
}
