import React from 'react';
import Link from 'next/link';

const Header = () => {
 return (
    <>
        <Link href="/SignIn">
            <a>SignIn</a>
        </Link>
        <Link href="/SignUp">
            <a>SingUp</a>
        </Link>
    </>
 );
}

export default Header;