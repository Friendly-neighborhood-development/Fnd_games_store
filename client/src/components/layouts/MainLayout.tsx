import React, {FC} from 'react';
import Sidebar from "../Sidebar";
import Navbar from "../Navbar";

interface MainLayoutProps{
    children?: React.ReactNode
}

const MainLayout:FC<MainLayoutProps> = ({children}) => {
    return (
        <div className="container mx-auto min-h-screen">
            <div className="flex flex-col items-center pt-2 lg:pt-8">
                <Navbar/>
                    {children}
            </div>
        </div>
    );
};

export default MainLayout;