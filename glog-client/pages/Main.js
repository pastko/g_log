import React, { useEffect, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import Post from '../components/Post';
import styled from 'styled-components';

const Main = () => {
    const [items, setItems] = useState([]);

    const [noMore, setnoMore] = useState(true);

    const [page, setpage] = useState(2);

    useEffect(() => {
        const getComments = async () => {
            const res = await fetch(
                `http://localhost:3004/comments?_page=1&_limit=20`
            );
            const data = await res.json();
            setItems(data);
            // try {
            //     return await axios.get(
            //         `http://localhost:3004/comments?_page=1&_limit=20`
            //     );
            // } catch (error) {
            //     console.error(error);
            // }
            // const data = await res.json();
            // setItems(data);
        };

        getComments();
    }, []);

    console.log(items);

    const fetchComments = async () => {
        const res = await fetch(
            `http://localhost:3004/comments?_page=${page}&_limit=20`
        );
        const data = await res.json();
        return data;
        // try {
        //     return await axios.get(
        //         `http://localhost:3004/comments?_page=${page}&_limit=20`
        //     );
        // } catch (error) {
        //     console.log(error);
        // }
        // const data = await res.json();
        // return data;
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
        <>
            <Recent>최신</Recent>
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
                    return (
                        <PostList>
                            <Post key={item.id} item={item} />
                        </PostList>
                    );
                })}
            </InfiniteScroll>
        </>
    );
};
export default Main;

const Recent = styled.div`
    max-width: 1024px;
    font-size: 18px;
    color: rgb(134, 142, 150);
    margin: 20px auto;
`;

const PostList = styled.div`
    float: left;
    display: flex;
    flex-wrap: wrap;
    gap: auto;
    max-width: 1024px;
    margin: 0 auto;
`;
