package com.doclink;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.doclink.model.UserModel;
import com.doclink.model.UserRole;
import com.doclink.service.UserService;

@RunWith(SpringRunner.class)
@JsonTest
class UserTests {
	
	@Autowired
	JacksonTester<UserModel> json;

	/*
	 * @Test void test() { UserModel nm = new UserModel((long)
	 * 1,"perry","luigi","sdfsdf","123ed","male","iowa","usa","adsdasd",true,
	 * UserRole.Role_Admin); boolean test = false; if(us.add(nm) != null) test =
	 * true; assertTrue(test); fail("Not yet implemented"); }
	 */
	
	@Test
	void test() {
		UserModel nm = new UserModel((long) 1,"perry","luigi","sdfsdf","123ed","male","iowa","usa","adsdasd",true,UserRole.Role_Admin);
		
		try {
			this.json.write(nm);
			assertThat(this.json.write(nm)).isEqualTo("{\"id\":1,\"fname\":\"perry\",\"lname\":\"luigi\",\"email\":\"sdfsdf\",\"password\":\"123ed\",\"gender\":\"male\",\"state\":\"iowa\",\"country\":\"usa\",\"profile_img\":\"adsdasd\",\"confirmed_email\":true,\"role\":\"Role_Admin\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
