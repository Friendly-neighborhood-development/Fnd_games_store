import React, {FC} from 'react';

interface NotLoginLayoutProps {
    children: React.ReactNode
}

const NotLoginLayout: FC<NotLoginLayoutProps> = ({children}) => {
    return (
        <div className="container mx-auto min-h-screen">
            {children}
        </div>
    );
};

export default NotLoginLayout;