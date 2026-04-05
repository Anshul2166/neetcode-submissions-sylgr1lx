class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparing(Point::getDistinceFromOrigin));

        for(int[] point : points){
            Point pointObj = new Point(point[0], point[1]);
            queue.add(pointObj);
        }

        int[][] res = new int[k][2];

        for(int i = 0; i < k; i++){
            if(!queue.isEmpty()){
                Point currPoint = queue.poll(); // get closest point from queue and remove it
                res[i][0] = currPoint.x;
                res[i][1] = currPoint.y;
            }
        }

        return res;
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    double getDistinceFromOrigin(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    // int[] getAsArray(){
    //     int[] arr = {this.x, this.y};
    //     return arr;
    // }
}
