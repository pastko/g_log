import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import Images from "../../layout/Images";

function Contents() {
    const dispatch = useDispatch();
    const { posts, detailPost } = useSelector((state) => ({
        posts: state.board.posts,
        detailPost: state.board.detailPost
    }));

    return (
        <StyledContents>
        </StyledContents>
        // <StyledContents dangerouslySetInnerHTML={{ __html: contents }}></StyledContents>
    );
}

const StyledContents = styled.div`
    margin-bottom: 4rem;
    p {
        text-align: left;
        margin-top: 50px;
        font-size: 1.3rem;
    }
`;

export default Contents;