import React, { FC } from 'react';

interface SidebarProps {
    children: React.ReactNode;
}

export const Sidebar: FC<SidebarProps> = ({ children }) => {
    return (
        <div
            className={
                'hidden lg:block fixed top-24 w-56 bg-white rounded-lg p-3 dark:bg-slate-800'
            }
        >
            {children}
        </div>
    );
};
