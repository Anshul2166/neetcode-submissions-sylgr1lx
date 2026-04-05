class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        course_preq_for = defaultdict(list)
        in_degree_list = [0] * numCourses

        # Store all courses for which the current course is a pre-req
        for course, pre_req in prerequisites:
            course_preq_for[pre_req].append(course)

            # Increment number of pre_req for given course
            in_degree_list[course] += 1

        queue = deque()
        
        # Add courses with no pre-req to the queue
        for course, in_degree in enumerate(in_degree_list):
            if in_degree == 0:
                queue.append(course)
        
        answer = []
        
        while queue:

            curr_course = queue.popleft()
            answer.append(curr_course)

            # Remove the course from the queue
            numCourses -= 1

            # Remove that course from pre-req for all courses
            for course in course_preq_for[curr_course]:
                in_degree_list[course] -= 1
                # If no pre-req for course exists, add to the queue
                if in_degree_list[course] == 0:
                    queue.append(course)
        
        if numCourses == 0:
            return answer
        
        return []