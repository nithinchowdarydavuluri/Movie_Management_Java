namespace java org.example.thrift

struct Theater {
    1: i64 id,
    2: string name,
    3: string location,
    4: string city,
    5: list<string> screens
}

service TheaterService {
    Theater getTheater(1: i32 theaterId),
    list<Theater> getAllTheaters(),
    bool createTheater(1: Theater theater),
    bool deleteTheater(1: i32 theaterId)
}