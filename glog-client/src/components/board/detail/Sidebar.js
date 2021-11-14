import styled from "styled-components";
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import ShareIcon from '@mui/icons-material/Share';
import { useState } from "react";
import { useSelector } from "react-redux";

function Sidebar() {

    const { liked } = useSelector((state) => state.post.detailPost);
    const [isLike, setIsLike] = useState(false);
    const toggleLike = () => {
        setIsLike(!isLike);
    }

    return (
        <StyledSidebar>
            <Like onClick={toggleLike}>
                {isLike ? <FavoriteIcon /> : <FavoriteBorderIcon />}
                <Count color={isLike ? '#fff' : '#a680d2'}>{liked}</Count>
            </Like>
            <Caption><ShareIcon /></Caption>
        </StyledSidebar>
    );
}
const StyledSidebar = styled.div`

`;
const Like = styled.div`
    
`;
const Count = styled.p`
    color: ${(props) => props.color};
    font-size: 1em;
    font-weight: 600;
`;
const Caption = styled.div`

`;
export default Sidebar;