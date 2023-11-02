package bookMagApp.tests;

import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.dto.UserDTO;
import com.Andrey.bookMagApp.converter.UserConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class UserConverterTest {
    private UserConverter userConverter;

    @Before
    public void setUp() {
        userConverter = new UserConverter();
    }

    @Test
    public void testToUserDTO() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Андрей");
        user.setDiscount(new BigDecimal("10.0"));

        UserDTO userDTO = userConverter.toUserDTO(user);

        assertEquals(user.getUserId(), userDTO.getUserId());
        assertEquals(user.getUserName(), userDTO.getUserName());
        assertEquals(user.getDiscount(), userDTO.getDiscount());
    }

    @Test
    public void testToUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(2);
        userDTO.setUserName("Дима");
        userDTO.setDiscount(new BigDecimal("15.0"));

        User user = userConverter.toUser(userDTO);

        assertEquals(userDTO.getUserId(), user.getUserId());
        assertEquals(userDTO.getUserName(), user.getUserName());
        assertEquals(userDTO.getDiscount(), user.getDiscount());
    }

    @Test
    public void testToUserDTOList() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Андрей");
        user1.setDiscount(new BigDecimal("10.0"));

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Дима");
        user2.setDiscount(new BigDecimal("15.0"));

        users.add(user1);
        users.add(user2);

        List<UserDTO> userDTOList = userConverter.toUserDTOList(users);

        assertEquals(2, userDTOList.size());
        assertEquals(user1.getUserId(), userDTOList.get(0).getUserId());
        assertEquals(user2.getUserId(), userDTOList.get(1).getUserId());
    }
}
