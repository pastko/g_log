import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";

function Contents() {
    const dispatch = useDispatch();
    const { posts, detailPost } = useSelector((state) => ({
        posts: state.board.posts,
        detailPost: state.board.detailPost
    }));

    return (
        <StyledContents></StyledContents>
        // <StyledContents dangerouslySetInnerHTML={{ __html: contents }}></StyledContents>
    );
}

const StyledContents = styled.div`

`;

export default Contents;