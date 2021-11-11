import type { NextPage } from 'next';
import React, {useState} from 'react';
import Head from 'next/head';
import Header from '../components/common/Header';
import Home from './Home';



const Index: NextPage = () => {
  
  return (
    <>
      <Head>
        <title>glog</title>
        <meta name="description" content="post management" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Header/>
      <Home />
    </>
  );
};

export default Index;
