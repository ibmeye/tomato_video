sudo ffmpeg -re -i video.mp4 -codec:v libx264 -codec:a aac -map 0 -f hls  -hls_list_size 6 -hls_wrap 10 -hls_time 10 ${sub-dir}/video.m3u8

