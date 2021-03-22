package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Pacient;
import ru.sapteh.model.Reference;

import java.util.List;


    public class ReferenceService implements DAO<Reference, Integer> {
        private final SessionFactory sessionFactory;
        public ReferenceService(SessionFactory sessionFactory){
            this.sessionFactory = sessionFactory;
        }

        @Override
        public List<Reference> readByAll() {
            try(Session session = sessionFactory.openSession()){
                return session.createQuery("FROM Reference", Reference.class).list();
            }
        }

        @Override
        public Reference read(Integer integer) {
            try(Session session = sessionFactory.openSession()){
                return session.get(Reference.class, integer);
            }
        }

        @Override
        public void create(Reference reference) {
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.save(reference);
                session.getTransaction().commit();
            }

        }

        @Override
        public void update(Reference reference) {
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.update(reference);
                session.getTransaction().commit();
            }

        }

        @Override
        public void delete(Reference reference) {
            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                session.delete(reference);
                session.getTransaction().commit();
            }

        }
}
