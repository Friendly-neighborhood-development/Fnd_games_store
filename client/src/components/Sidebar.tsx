import React, {FC, memo} from 'react';

const Sidebar: FC = memo(() => {
    return (
        <div className={"hidden lg:block fixed top-24 w-56 bg-white h-96 rounded-lg dark:bg-slate-800"}>
        </div>
    );
});

export default Sidebar;