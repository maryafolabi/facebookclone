package com.maryafolabi.facebookclone.repository;



import com.maryafolabi.facebookclone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //    List<Post> findAllByUserID(long userID);
//    void deleteById(long postID);
//    Post findByPostID(long PostID);


}
