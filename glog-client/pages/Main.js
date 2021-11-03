import axios from 'axios';
import React, { useEffect, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import Comment from '../components/Comment';

const Main = () => {
    const [items, setItems] = useState([]);

    const [noMore, setnoMore] = useState(true);

    const [page, setpage] = useState(2);

    useEffect(() => {
        const getComments = async () => {
            // const res = await axios.get(
            //     `http://localhost:3004/comments?_page=1&_limit=20`
            // );
            // const data = await res.json();
            // setItems(data);
            try {
                return await axios.get(
                    `http://localhost:3004/comments?_page=1&_limit=20`
                );
            } catch (error) {
                console.error(error);
            }
            const data = await res.json();
            setItems(data);
        };

        getComments();
    }, []);

    console.log(items);

    const fetchComments = async () => {
        // const res = await axios.get(
        //     `http://localhost:3004/comments?_page=${page}&_limit=20`
        // );
        // const data = await res.json();
        // return data;
        try {
            return await axios.get(
                `http://localhost:3004/comments?_page=${page}&_limit=20`
            );
        } catch (error) {
            console.log(error);
        }
        const data = await res.json();
        return data;
    };
    const fetchData = async () => {
        const commentsFormServer = await fetchComments();
        setItems([...items, ...commentsFormServer]);

        if (commentsFormServer.length === 0 || commentsFormServer.length < 20) {
            setnoMore(false);
        }

        setpage(page + 1);
        console.log('hello');
    };

    return (
        <InfiniteScroll
            dataLength={items.length} //This is important field to render the next data
            next={fetchData}
            hasMore={noMore}
            loader={<h4>Loading...</h4>}
            endMessage={
                <p style={{ textAlign: 'center' }}>
                    <b></b>
                </p>
            }
        >
            {items.map((item) => {
                return <Comment key={item.id} item={item} />;
            })}
        </InfiniteScroll>
    );
};
export default Main;
