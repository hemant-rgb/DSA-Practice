class DetectSquares {
private:
    unordered_map<string,int> pointCount;
    vector<vector<int>> points;
public:
    
    DetectSquares() {

        
    }
    
    void add(vector<int> point) {
        int x = point[0];
        int y = point[1];

        string key = to_string(x) + "," + to_string(y);

        pointCount[key]++;
        points.push_back(point);
        
    }
    
    int count(vector<int> point) {
        int x = point[0];
        int y = point[1];

        int ans =0;

        for(auto &p : points){
            int x1 = p[0];
            int y1  = p[1];
            if(abs(x1-x)!= abs(y1-y)||x1==x || y1==y){
                continue;
            }

            string p1 = to_string(x1) + "," + to_string(y);
            string p2 = to_string(x)+ "," + to_string(y1);

            ans += pointCount[p1]*pointCount[p2];
        }

        return ans;
        
    }
};

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares* obj = new DetectSquares();
 * obj->add(point);
 * int param_2 = obj->count(point);
 */