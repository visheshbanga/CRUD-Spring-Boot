# CRUD using Spring Boot

### Introduction
Implementation of CRUD operations using JPA and PostgreSQL database.

### Relations
* **Users:** 
  * It contains following fields: id, username, password, email
* **Followers:**
  * It contains following fields: id, follower_id (reference user(id)), following_id (reference user(id))
* **Posts:**
  * It contains following fields: id, user_id (reference user(id)), post

### APIs
* **/signUp:** It is a post request that requests user details as paramaters and saves it in "users" table.
* **/login:** It is a post request that accepts username and password and returns returns welcome message if details are valid.
* **/search:** It is a post request that accepts a string and return list of users that contains string in their name.
* **/add_to_network:** It is a post request that accepts follower_id and following_id and creates a new entry in "follower" table if not exists.
* **/find_followers:** It accepts a user_id and returns a list of followers.
* **/create_post:** It accepts user_id and post message and creates a new entry in "posts" table.
* **/get_post:** It is get request that accepts user_id as path variable as return posts of all the users followed by user sorted in descending order by creation time.
