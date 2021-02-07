package ru.geekbrains.persist;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener    //не забываем аннотоцию, благодаря данной аннотации данный класс будет зарегистрирован в кач. листнера
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();    //делаем так,чтоб данный класс был доступен всем сервлетам
        UserRepository userRepository = new UserRepository();   //создаем экземпляр нашего репозитория
        sc.setAttribute("userRepository", userRepository);

        userRepository.insert(new User("user1"));
        userRepository.insert(new User("user2"));
        userRepository.insert(new User("user3"));

}
