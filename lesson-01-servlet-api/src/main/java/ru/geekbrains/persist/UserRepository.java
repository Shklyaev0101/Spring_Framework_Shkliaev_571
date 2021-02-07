package ru.geekbrains.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {

    private Map<Long, User> userMap = new ConcurrentHashMap<>(); //для простоты и быстроты исп.не список, а мапу

    private AtomicLong identity = new AtomicLong(0); // делаем генератор id для нашей сущности

    public List<User> findAll() { //метод,кот.возвращает список всех пользователей, кот. хранятся тут
        return new ArrayList<>(userMap.values(); //!!! приводим к типу List
    }

    public User findById(long id) { //метод кот.возвращал бы пользователя по его идентификатору
        return userMap.get(id); // реализация метода findById
    }

    public void insert(User user) { //метод кот.добавляет нового пользователя
        long id = identity.incrementAndGet();    // реализация метода insert
        user.setId(id);
        userMap.put(id, user);
    }

    public void update(User user) { //метод,кот.изменяет пользователя
        userMap.put(user.getId(), user);    // реализация метода update
    }

    public void delete(long id) { //метод кот. удаляет пользователя по id

    }

}
