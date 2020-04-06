package com.doclink;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.doclink.model.User;
import com.doclink.model.UserRole;

@RunWith(SpringRunner.class)
@JsonTest
class UserTests {
	
	@Autowired
	JacksonTester<User> json;

	/*
	 * @Test void test() { UserModel nm = new UserModel((long)
	 * 1,"perry","luigi","sdfsdf","123ed","male","iowa","usa","adsdasd",true,
	 * UserRole.Role_Admin); boolean test = false; if(us.add(nm) != null) test =
	 * true; assertTrue(test); fail("Not yet implemented"); }
	 */
	
	@Test
	void test() {
		User nm = new User(
				(long) 1,
				"perry",
				"luigi",
				"perry@gmai.com",
				"123ed",
				"male",
				"iowa",
				"usa",
				"adsdasd",
				true,
				UserRole.ROLE_ADMIN);
		
		try {
			this.json.write(nm);
			assertThat(this.json.write(nm)).isEqualTo("{\"id\":1,\"firstName\":\"perry\",\"lastName\":\"luigi\",\"email\":\"perry@gmai.com\",\"gender\":\"male\",\"state\":\"iowa\",\"country\":\"usa\",\"profileImg\":\"adsdasd\",\"confirmedEmail\":true,\"role\":\"ROLE_ADMIN\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
