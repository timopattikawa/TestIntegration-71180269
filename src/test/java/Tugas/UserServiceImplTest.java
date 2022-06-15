package Tugas;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceImplTest {

//    dummy class
    User user = Mockito.mock(User.class);

//    mock Object
    SecurityService securityService = Mockito.mock(SecurityService.class);
    UserDAO userDAO = Mockito.mock(UserDAO.class);


    @Test
    public void testAssignPassword() throws Exception {
        String dummyHashMD5 = "cc03e747a6afbbcbf8be7668acfebee5";
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
        Mockito.when(user.getPassword()).thenReturn("test123");
        Mockito.when(securityService.md5(user.getPassword())).thenReturn(dummyHashMD5);

//        Test act
        sut.assignPassword(user);

//        verify
        Mockito.verify(user).setPassword(dummyHashMD5);
        Mockito.verify(userDAO).updateUser(user);

    }

}